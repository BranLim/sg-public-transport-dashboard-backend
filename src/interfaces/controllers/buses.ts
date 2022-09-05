import axios, { AxiosRequestConfig } from 'axios';
import { Request, Response } from 'express';
import { BusArrival, BusArrivals } from '../types/busarrivals';
import { LtaBusService } from '../../infrastructure/types/LtaBusArrival';

const axiosConfiguration: AxiosRequestConfig = {
    headers: {
        AccountKey: process.env.LTA_ACCOUNT_KEY || '',
    },
    baseURL: 'http://datamall2.mytransport.sg/ltaodataservice',
};

const authAxios = axios.create(axiosConfiguration);

export const getBusArrivals = async (req: Request, res: Response) => {
    const response = await authAxios.get(
        `BusArrivalv2?BusStopCode=${req.params.busStopNumber}`
    );

    const busServices: LtaBusService[] = response.data
        ?.Services as LtaBusService[];
    if (!busServices) {
        return res.status(500);
    }

    const busArrivals: BusArrivals = {
        services: busServices.map((busService: LtaBusService) => {
            return {
                busNo: busService.ServiceNo,
                estimatedArrivalTimes: [],
            } as BusArrival;
        }),
    };
    return res.status(200).json(busArrivals);
};
