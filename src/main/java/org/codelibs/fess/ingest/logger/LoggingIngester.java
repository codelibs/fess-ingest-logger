package org.codelibs.fess.ingest.logger;

import java.util.Map;

import org.codelibs.fess.crawler.entity.AccessResult;
import org.codelibs.fess.crawler.entity.AccessResultData;
import org.codelibs.fess.crawler.entity.ResponseData;
import org.codelibs.fess.crawler.entity.ResultData;
import org.codelibs.fess.crawler.transformer.Transformer;
import org.codelibs.fess.ingest.Ingester;
import org.codelibs.fess.util.ComponentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingIngester extends Ingester {
    private static final Logger logger = LoggerFactory.getLogger(LoggingIngester.class);

    @Override
    public Map<String, Object> process(final Map<String, Object> target, final Map<String, String> params) {
        log("DATASTORE CRAWL: %s", target);
        return target;
    }

    @Override
    public ResultData process(final ResultData target, final ResponseData responseData) {
        final AccessResult<?> accessResult = ComponentUtil.getComponent("accessResult");
        accessResult.init(responseData, target);
        final AccessResultData<?> accessResultData = accessResult.getAccessResultData();
        final Transformer transformer = ComponentUtil.getComponent(accessResultData.getTransformerName());
        final Object data = transformer.getData(accessResultData);
        log("WEB/FILE CRAWL: %s", data);
        return target;
    }

    protected void log(final String format, final Object data) {
        if (logger.isInfoEnabled()) {
            logger.info(String.format(format, data));
        }
    }
}
