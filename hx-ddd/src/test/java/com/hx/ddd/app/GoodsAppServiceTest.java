package com.hx.ddd.app;

import com.hx.ddd.app.dto.EnergyDTO;
import com.hx.ddd.app.dto.GoodsDTO;
import org.junit.Ignore;
import org.junit.Test;

public class GoodsAppServiceTest {
    /**
     * Method under test: {@link GoodsAppService#getGoodsDTO()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetGoodsDTO() {

        // Arrange
        // TODO: Populate arranged inputs
        GoodsAppService goodsAppService = new GoodsAppService();

        // Act
        GoodsDTO actualGoodsDTO = goodsAppService.getGoodsDTO();

        // Assert
        // TODO: Add assertions on result
        System.out.println(actualGoodsDTO);

        EnergyDTO energyDTO = goodsAppService.getEnergyDTO();
        System.out.println(energyDTO);
    }


}

