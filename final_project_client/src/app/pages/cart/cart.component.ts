import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [],
  templateUrl: './cart.component.html',
})
export class CartComponent implements OnInit, OnDestroy {
  private _subscription = new Subscription();

  constructor(private _authService: AuthService, private _router: Router) { }

  ngOnInit(): void {
    this._subscription.add(
      this._authService.isLoggedIn()
        .subscribe(isLoggedIn => {
          if (!isLoggedIn) {
            this._router.navigateByUrl('/plp')
          }
        })
    );
  }

  ngOnDestroy(): void {
    this._subscription.unsubscribe();
  }
}
