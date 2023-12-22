import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { AsyncPipe, JsonPipe, NgForOf, NgIf } from "@angular/common";
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import {BehaviorSubject, filter, map, Observable, Subscription, switchMap} from "rxjs";

import { PdpService } from "../../services/pdp.service";
import { ProductPdp } from "../../models/product-pdp";

export interface PriceVariant {
  productId: number;
  price: string;
}

@Component({
  selector: 'app-pdp',
  standalone: true,
  imports: [
    NgIf,
    AsyncPipe,
    JsonPipe,
    NgForOf
  ],
  templateUrl: './pdp.component.html',
  styleUrl: './pdp.component.scss'
})
export class PdpComponent implements OnInit, OnDestroy {
  private _subscription = new Subscription();

  private _productPdpSub$
    = new BehaviorSubject<ProductPdp | undefined>(undefined);
  private _priceSub$
    = new BehaviorSubject<PriceVariant | undefined>(undefined);

  readonly productPdp$: Observable<ProductPdp | undefined> = this._productPdpSub$.asObservable();
  readonly price$: Observable<PriceVariant | undefined> = this._priceSub$.asObservable();

  ssdSet: Set<number> = new Set<number>();
  ramSet: Set<number> = new Set<number>();

  form: FormGroup = this._fb.group({
    ram: new FormControl(null, [Validators.required]),
    ssd: new FormControl(null, [Validators.required]),
  });

  constructor(
    private _router: Router,
    private _fb: FormBuilder,
    private _pdpService: PdpService) {
  }

  ngOnInit(): void {
    let url = this._router.routerState.snapshot.url;
    let productId = url.substring(url.lastIndexOf('/') + 1, url.length);
    if (productId) {
      this._subscription.add(
        this._pdpService.loadProductVariants(productId)
          .subscribe(product => {
            if (product) {
              product.variants.forEach(variant => {
                this.ssdSet.add(variant.ssd);
                this.ramSet.add(variant.ram);
              })
              this._productPdpSub$.next(product);
            }
          })
      );
    }
    this._subscription.add(
      this.form.valueChanges
        .pipe(
          filter(value => value.ram && value.ssd),
          switchMap(value => {
            return this.productPdp$
              .pipe(
                map(product => {
                  let variants = product?.variants;
                  if (variants) {
                    for (let i = 0; i < variants?.length; i++) {
                      if (variants[i].ram === value.ram && variants[i].ssd === value.ssd) {
                        this._priceSub$.next({
                          price: variants[i].price,
                          productId: variants[i].id
                        });
                        break;
                      } else {
                        this._priceSub$.next(undefined);
                      }
                    }
                  }
                  return value;
                })
              )
          })
        )
        .subscribe()
    );
  }

  addSsd(ssd: number): void {
    this.form.controls['ssd'].setValue(ssd);
  }

  addRam(ram: number): void {
    this.form.controls['ram'].setValue(ram);
  }

  shopNow(productId: number | undefined): void {
    if (productId) {
      console.log('productId', productId)
    }
  }

  ngOnDestroy(): void {
    this._subscription.unsubscribe();
    this._productPdpSub$.complete();
    this._priceSub$.complete();
  }
}
