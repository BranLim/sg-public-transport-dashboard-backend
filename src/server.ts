import express, { Express } from 'express';

const app: Express = express();
const port = process.env.APPLICATION_PORT || 3001;

app.use(express.json());

app.listen(port, () => {
    console.log(`[Server] Started at http://localhost:${port}`);
});

