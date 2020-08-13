package com.gly.producer.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.*;
import org.slf4j.MDC;

import java.util.UUID;


@Activate(group = {Constants.PROVIDER})
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
