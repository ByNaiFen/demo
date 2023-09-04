package com.example.employeeadmin.demos.web.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.employeeadmin.demos.domains.dto.EmployeeDto;
import com.example.employeeadmin.demos.domains.po.Employee;
import com.example.employeeadmin.demos.domains.po.User;
import com.example.employeeadmin.demos.domains.vo.EmployeePageVo;
import com.example.employeeadmin.demos.service.EmployeeService;
import com.example.employeeadmin.demos.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author YeShaoKang
 * @date 2023/9/4 3:00
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
@Api(tags = "职工管理API")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/query")
    @Operation( summary = "职工列表查询", description = "职工列表查询", method = "GET")
    public ResponseResult queryWhereClauses(@Parameter(description = "职工信息") EmployeePageVo employeeVo){
        Page<Employee> page = employeeService.lambdaQuery()
                .eq(StringUtils.isNotBlank(employeeVo.getEmpName()), Employee::getEmpName, employeeVo.getEmpName())
                .eq(Objects.nonNull(employeeVo.getDeptName()), Employee::getDeptName, employeeVo.getDeptName())
                .eq(Objects.nonNull(employeeVo.getEmpDegreeName()), Employee::getEmpDegreeName, employeeVo.getEmpDegreeName())
                .page(new Page<>(employeeVo.getPageNum(), employeeVo.getPageSize()));

        return new ResponseResult<>(200, "", page);
    }

    @PostMapping("/add")
    @Operation( summary = "职工信息添加", description = "职工信息添加", method = "POST")
    public ResponseResult add(@RequestBody @Parameter(description = "职工信息") Employee employee){
        employeeService.add(employee);
        return new ResponseResult<>(200, "添加成功", null);
    }

    @PostMapping("/update")
    @Operation( summary = "职工信息修改", description = "职工信息修改", method = "POST")
    public ResponseResult modify(@RequestBody @Parameter(description = "职工信息") Employee employee){
        employeeService.modify(employee);
        return new ResponseResult<>(200, "修改成功", null);
    }

    @PostMapping("/delete/{id}")
    @Operation( summary = "职工信息删除", description = "职工信息删除", method = "POST")
    public ResponseResult add(@PathVariable("id") @Parameter(description = "职工ID") Integer id){
        employeeService.deleteById(id);

        return new ResponseResult<>(200, "删除成功", null);
    }

    @GetMapping(value = "/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @Operation( summary = "职工信息导出", description = "职工信息导出", method = "GET")
    public ResponseEntity<byte[]> exportToExcel(@Parameter(description = "职工信息") Employee employee) throws IOException {
        List<EmployeeDto> employeeList = employeeService.queryExportData(employee);

        // 创建工作簿
        Workbook workbook = new XSSFWorkbook();
        // 创建工作表
        Sheet sheet = workbook.createSheet("Data");
        // 创建标题行
        Row headerRow = sheet.createRow(0);
        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerCellStyle.setFont(headerFont);

        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("职工姓名");
        headerCell1.setCellStyle(headerCellStyle);

        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("性别");
        headerCell2.setCellStyle(headerCellStyle);

        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("年龄");
        headerCell3.setCellStyle(headerCellStyle);

        Cell headerCell4 = headerRow.createCell(3);
        headerCell4.setCellValue("部门名称");
        headerCell4.setCellStyle(headerCellStyle);

        Cell headerCell5 = headerRow.createCell(4);
        headerCell5.setCellValue("学历");
        headerCell5.setCellStyle(headerCellStyle);

        int rowNum = 1;
        for (EmployeeDto employeeDto : employeeList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(employeeDto.getEmpName());
            row.createCell(1).setCellValue(employeeDto.getSex());
            row.createCell(2).setCellValue(employeeDto.getAge());
            row.createCell(3).setCellValue(employeeDto.getDeptName());
            row.createCell(4).setCellValue(employeeDto.getEmpDegreeName());
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(outputStream.toByteArray());
    }
}
