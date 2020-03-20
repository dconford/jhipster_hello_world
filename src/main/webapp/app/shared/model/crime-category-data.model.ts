import { IReportedEvents } from 'app/shared/model/reported-events.model';

export interface ICrimeCategoryData {
  id?: number;
  crimeCategoryId?: number;
  crimeCategory?: string;
  reportedEvents?: IReportedEvents[];
}

export class CrimeCategoryData implements ICrimeCategoryData {
  constructor(
    public id?: number,
    public crimeCategoryId?: number,
    public crimeCategory?: string,
    public reportedEvents?: IReportedEvents[]
  ) {}
}
