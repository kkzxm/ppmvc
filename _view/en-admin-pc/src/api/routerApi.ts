import { BaseApi } from "./BaseApi";

class routerApi extends BaseApi {
    constructor() {
        super("/router");
    }
}

export const routerObj = new routerApi()