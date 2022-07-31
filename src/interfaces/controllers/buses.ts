import axios, { AxiosRequestConfig } from 'axios';
import { Request, Response, NextFunction } from 'express';

const axiosConfiguration: AxiosRequestConfig = {
    headers: {
        AccountKey: process.env.LTA_ACCOUNT_KEY || '',
    },
    baseURL: 'http://datamall2.mytransport.sg/ltaodataservice',
};

const authAxios = axios.create(axiosConfiguration);

const getBusArrivals = async (req: Request, res: Response, next: NextFunction) => {
    const response = await authAxios.get(
        `BusArrivalv2?BusStopCode=${req.query.busStopCode}`
    );
    return res.status(200).json(
        response.data
    );
};


export default { getBusArrivals };