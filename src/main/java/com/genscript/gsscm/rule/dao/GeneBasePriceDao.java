package com.genscript.gsscm.rule.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.genscript.gsscm.rule.entity.GeneBasePrice;

@Repository
public class GeneBasePriceDao extends BaseDao<GeneBasePrice, Integer> {

    /**
     * 通过CatalogNo和序列长度查询价格记录
     */
    public GeneBasePrice searchByVersion(String catalogNo, Integer seqLength, String cloningReadyFlag, String locCode, String version) {
        String hql = "FROM GeneBasePrice WHERE catalogNo=:catalogNo AND :seqLength BETWEEN IFNULL(seqLengthFrom,:seqLength) AND IFNULL(seqLengthTo,:seqLength) AND locCode=:locCode and cloningReadyFlag=:cloningReadyFlag ";
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(version)) {
            hql += " AND version=:version";
            map.put("version", version);
        }
        hql += " ORDER BY version DESC";
        map.put("catalogNo", catalogNo);
        map.put("seqLength", seqLength);
        map.put("locCode", locCode);
        map.put("cloningReadyFlag", cloningReadyFlag);
        List<GeneBasePrice> geneBasePriceList = this.find(hql, map);
        if (geneBasePriceList != null && !geneBasePriceList.isEmpty()) {
            return geneBasePriceList.get(0);
        }
        return null;
    }
}
