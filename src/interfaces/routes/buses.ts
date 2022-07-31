import express from 'express';
import controller from '../controllers/buses';

const router = express.Router();

router.get("/bus-arrivals", controller.getBusArrivals);

export = router;