
import { NgModule } from "@angular/core";
import { MarcaRoutingModule } from "./marca-routing.module";
import { SharedModule } from "src/app/shared/shared.module";
import { MarcaListComponent } from "./marca-list/marca-list.component";
import { MarcaFormComponent } from "./marca-form/marca-form.component";

@NgModule({
  declarations: [MarcaListComponent, MarcaFormComponent],
  imports: [SharedModule, MarcaRoutingModule]
})
export class MarcaModule { }
