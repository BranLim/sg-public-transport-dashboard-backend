import express, { Express, Request, Response } from 'express';
import { busRoute } from './interfaces/routes';

const app: Express = express();
const port = process.env.APPLICATION_PORT || 3001;

app.use(express.json());

app.use((req: Request, res: Response, next) => {
    // set the CORS policy
    res.header('Access-Control-Allow-Origin', '*');
    // set the CORS headers
    res.header(
        'Access-Control-Allow-Headers',
        'origin, X-Requested-With,Content-Type,Accept, Authorization'
    );
    // set the CORS method headers
    if (req.method === 'OPTIONS') {
        res.header('Access-Control-Allow-Methods', 'GET PATCH DELETE POST');
        return res.status(200).json({});
    }
    return next();
});

app.use('/', busRoute);

app.listen(port, () => {
    console.log(`[Server] Started at http://localhost:${port}`);
});
