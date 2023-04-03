package com.hx.ddd.app.assember;

import com.hx.ddd.app.dto.EnergyDTO;
import com.hx.ddd.app.dto.GoodsDTO;
import com.hx.ddd.domain.model.Energy;
import com.hx.ddd.domain.model.Goods;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * dto汇编
 *
 * @author kyle
 * @date 2023/02/17
 */
@Mapper
public interface DtoAssembler {
    DtoAssembler INSTANCE = Mappers.getMapper(DtoAssembler.class);

    /**
     * 货物货物dto
     *
     * @param goods 货物
     * @return {@link GoodsDTO}
     */
    @Mapping(source = "name",target = "goodsName")
    GoodsDTO goodsToGoodsDto(Goods goods);

    /**
     * 能源dto
     *
     * @param energy 能源
     * @return {@link EnergyDTO}
     */
    @Mapping(source = "c",target = "cargoEnergy")
    EnergyDTO toEnergyDTO(Energy energy);

    /**
     * 更新产品
     *
     * @param goodsDTO 货物dto
     * @param car      车
     */
    void updateGoods(@MappingTarget GoodsDTO goodsDTO, Goods car);

}
