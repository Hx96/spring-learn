package com.hx.ddd.app;

import com.hx.ddd.app.assember.DtoAssembler;
import com.hx.ddd.app.dto.EnergyDTO;
import com.hx.ddd.app.dto.GoodsDTO;
import com.hx.ddd.domain.model.Energy;
import com.hx.ddd.domain.model.Goods;

/**
 * 产品应用服务
 *
 * @author kyle
 * @date 2023/02/17
 */
public class GoodsAppService {

    public GoodsDTO getGoodsDTO() {
        Goods apple = Goods.builder().name("苹果").price(10L).build();
        return DtoAssembler.INSTANCE.goodsToGoodsDto(apple);
    }

    public EnergyDTO getEnergyDTO() {
        Energy build = Energy.builder().c(5).build();
        return DtoAssembler.INSTANCE.toEnergyDTO(build);
    }


}
