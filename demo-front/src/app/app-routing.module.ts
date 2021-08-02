import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { CarroModule } from "./models/carro/carro.module";
import { MarcaModule } from "./models/marca/marca.module";

const routes: Routes = [
  {
    path: "marca",
    loadChildren: () => MarcaModule
  },
  { path: "carro", loadChildren: () => CarroModule }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
