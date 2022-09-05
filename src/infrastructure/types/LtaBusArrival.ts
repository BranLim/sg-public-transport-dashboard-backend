export interface LtaBus {
    OriginCode: string;
    DestinationCode: string;
    EstimatedArrival: string;
    Latitude: string;
    Longitude: string;
    VisitNumber: string;
    Load: string;
    Feature: string;
    Type: string;
}

export interface LtaBusService {
    ServiceNo: string;
    Operator: string;
    NextBus: LtaBus;
    NextBus2: LtaBus;
    NextBus3: LtaBus;
}

export interface LtaBusArrival {
    'odata.metadata': string;
    BusStopCode: string;
    Services: LtaBusService[];
}
