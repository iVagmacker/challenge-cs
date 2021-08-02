
import { NgModule } from "@angular/core";
import { CarroRoutingModule } from "./carro-routing.module";
import { SharedModule } from "src/app/shared/shared.module";
import { CarroFormComponent } from '../carro/carro-form/carro-form.component';
import { CarroListComponent } from '../carro/carro-list/carro-list.component';

@NgModule({
  declarations: [CarroFormComponent, CarroListComponent],
  imports: [SharedModule, CarroRoutingModule]
})
export class CarroModule { }
