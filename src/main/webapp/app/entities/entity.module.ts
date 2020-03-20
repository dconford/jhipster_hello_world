import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'crime-category-data',
        loadChildren: () =>
          import('./crime-category-data/crime-category-data.module').then(m => m.JhipsterHelloWorldCrimeCategoryDataModule)
      },
      {
        path: 'neighborhood-data',
        loadChildren: () => import('./neighborhood-data/neighborhood-data.module').then(m => m.JhipsterHelloWorldNeighborhoodDataModule)
      },
      {
        path: 'coded-date-data',
        loadChildren: () => import('./coded-date-data/coded-date-data.module').then(m => m.JhipsterHelloWorldCodedDateDataModule)
      },
      {
        path: 'reported-events',
        loadChildren: () => import('./reported-events/reported-events.module').then(m => m.JhipsterHelloWorldReportedEventsModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class JhipsterHelloWorldEntityModule {}
