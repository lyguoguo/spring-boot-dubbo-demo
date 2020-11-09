package com.gly.producer.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.*;
import org.slf4j.MDC;

import java.util.UUID;


@Activate(group = {CommonConstants.PROVIDER})
public class TraceIdFilter implements Filter {

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		String traceId = invocation.getAttachment("traceId");
		if(StringUtils.isBlank(traceId)) {
			traceId = UUID.randomUUID().toString().replace("-", "");
			RpcContext.getContext().setAttachment("traceId", traceId);
		}
		MDC.put("traceId",traceId);
		return invoker.invoke(invocation);
	}
}
