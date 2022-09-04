export interface BusArrival {
    busNo: string;
    estimatedArrivalTimes: string[];
}

export interface BusArrivals {
    services: BusArrival[];
}
