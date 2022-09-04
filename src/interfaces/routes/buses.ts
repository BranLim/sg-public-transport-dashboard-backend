import express from 'express';
import { getBusArrivals } from '../controllers';

const router = express.Router();

router.get('/busstops/:busStopNumber/arrivals', getBusArrivals);

export { router as busRoute };
