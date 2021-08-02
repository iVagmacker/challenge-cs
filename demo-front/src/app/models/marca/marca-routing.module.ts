import { MarcaListComponent } from "./marca-list/marca-list.component";
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { MarcaFormComponent } from "./marca-form/marca-form.component";

const routes: Routes = [
  { path: "", component: MarcaListComponent },
  { path: "novo", component: MarcaFormComponent },
  { path: 'editar/:id', component: MarcaFormComponent },
  { path: 'visualizar/:id', component: MarcaFormComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MarcaRoutingModule { }
