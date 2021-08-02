import { NgModule, Optional, SkipSelf } from "@angular/core";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { RouterModule } from "@angular/router";
import { HttpClientModule } from "@angular/common/http";
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [],
  exports: [BrowserAnimationsModule, HttpClientModule],
  imports: [SharedModule, RouterModule]
})
export class CoreModule {
  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    if (parentModule) {
      throw new Error(
        "CoreModule is already loaded. Import it in the AppModule only."
      );
    }
  }
}
