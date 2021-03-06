import { IReportedEvents } from 'app/shared/model/reported-events.model';

export interface INeighborhoodData {
  id?: number;
  neighborhoodId?: number;
  neighborhoodName?: string;
  reportedEvents?: IReportedEvents[];
}

export class NeighborhoodData implements INeighborhoodData {
  constructor(
    public id?: number,
    public neighborhoodId?: number,
    public neighborhoodName?: string,
    public reportedEvents?: IReportedEvents[]
  ) {}
}
