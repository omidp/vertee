package com.jedlab.vertee.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import com.jedlab.vertee.DatabaseService;

public class DatabaseServiceImpl implements DatabaseService
{

    @Override
    public void persist(JsonObject document, Handler<AsyncResult<JsonObject>> resultHandler)
    {
        JsonObject result = document.copy();
        result.put("approved", true);
        resultHandler.handle(Future.succeededFuture(result));
    }

}
