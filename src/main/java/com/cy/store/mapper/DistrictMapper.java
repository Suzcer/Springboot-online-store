package com.cy.store.mapper;

import com.cy.store.entity.District;

import java.util.List;

public interface DistrictMapper {

    /**
     *  根据父代号查询区域信息，返回区域列表
     * @param parent
     * @return
     */
    List<District> findByParent(String parent);

    String findNameByCode(String code);

}
