import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterHelloWorldSharedModule } from 'app/shared/shared.module';
import { NeighborhoodDataComponent } from './neighborhood-data.component';
import { NeighborhoodDataDetailComponent } from './neighborhood-data-detail.component';
import { NeighborhoodDataUpdateComponent } from './neighborhood-data-update.component';
import { NeighborhoodDataDeleteDialogComponent } from './neighborhood-data-delete-dialog.component';
import { neighborhoodDataRoute } from './neighborhood-data.route';

@NgModule({
  imports: [JhipsterHelloWorldSharedModule, RouterModule.forChild(neighborhoodDataRoute)],
  declarations: [
    NeighborhoodDataComponent,
    NeighborhoodDataDetailComponent,
    NeighborhoodDataUpdateComponent,
    NeighborhoodDataDeleteDialogComponent
  ],
  entryComponents: [NeighborhoodDataDeleteDialogComponent]
})
export class JhipsterHelloWorldNeighborhoodDataModule {}
