package top.axbt.pta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.axbt.pta.domain.TbInfo;
import top.axbt.pta.service.InfoService;
import top.axbt.pta.utils.ExportExcelUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping("/user")
public class ExcellController {

    @Autowired
    private InfoService infoService;

    @RequestMapping(value = "/excel/exportBankCheckInfo/zhuxiao",method = RequestMethod.GET)
    public void ExportBankCkeckInfo(HttpServletResponse response, HttpServletRequest request){
        //得到所有要导出的数据
       List<TbInfo> errList = infoService.findZhuXiao();

        //定义导出的excel名字
        String excelName = "主校表";

        //获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("num","编号");
        fieldMap.put("name","姓名");
        fieldMap.put("l01","1题分");
        fieldMap.put("l02","2题分");
        fieldMap.put("l03","3题分");
        fieldMap.put("date","日期");

        //导出用户相关信息
        ExportExcelUtils.export(excelName,errList,fieldMap,response);
    }

    @RequestMapping(value = "/excel/exportBankCheckInfo/jinchen",method = RequestMethod.GET)
    public void ExportBankCkeckInfoJinChen(HttpServletResponse response, HttpServletRequest request){
        //得到所有要导出的数据
        List<TbInfo> errList = infoService.findJinChen();

        //定义导出的excel名字
        String excelName = "晋校表";

        //获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("num","编号");
        fieldMap.put("name","姓名");
        fieldMap.put("l01","1题分");
        fieldMap.put("l02","2题分");
        fieldMap.put("l03","3题分");
        fieldMap.put("date","日期");

        //导出用户相关信息
        ExportExcelUtils.export(excelName,errList,fieldMap,response);
    }
}

