import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { JhipsterHelloWorldSharedModule } from 'app/shared/shared.module';
import { JhipsterHelloWorldCoreModule } from 'app/core/core.module';
import { JhipsterHelloWorldAppRoutingModule } from './app-routing.module';
import { JhipsterHelloWorldHomeModule } from './home/home.module';
import { JhipsterHelloWorldEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    JhipsterHelloWorldSharedModule,
    JhipsterHelloWorldCoreModule,
    JhipsterHelloWorldHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    JhipsterHelloWorldEntityModule,
    JhipsterHelloWorldAppRoutingModule
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent]
})
export class JhipsterHelloWorldAppModule {}
