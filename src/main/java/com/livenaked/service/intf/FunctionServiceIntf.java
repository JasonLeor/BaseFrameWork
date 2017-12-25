package com.livenaked.service.intf;

import com.livenaked.entity.FunctionStatusEnum;
import com.livenaked.model.PFunction;

public interface FunctionServiceIntf {

    boolean hasFunction(String route);

    FunctionStatusEnum getFunctionStatus(String route);

    PFunction findFunction(String route);

}
