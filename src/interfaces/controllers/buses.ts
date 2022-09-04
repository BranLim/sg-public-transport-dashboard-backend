import axios, { AxiosRequestConfig } from 'axios';
import { Request, Response } from 'express';
import { BusArrival, BusArrivals } from '../types/busarrivals';

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

    const busServices = response.data?.Services;
    if (!busServices) {
        return res.status(500);
    }

    const busArrivals: BusArrivals = {
        services: busServices.map((s: unknown) => {
            return {
                busNo: s.ServiceNo,
                estimatedArrivalTimes: [],
            } as BusArrival;
        }),
    };
    return res.status(200).json(busArrivals);
};
