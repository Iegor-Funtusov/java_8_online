import { ProductVariant } from "./product-variant";

export interface ProductPdp {
  id: number;
  name: string;
  description: string;
  displayResolution: string;
  camera: string;
  battery: string;
  images: string[];
  variants: ProductVariant[];
}
