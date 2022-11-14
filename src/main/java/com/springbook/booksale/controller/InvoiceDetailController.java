package com.springbook.booksale.controller;

import com.springbook.booksale.entity.InvoicedetailEntity;
import com.springbook.booksale.service.InvoiceDetailService;
import com.springbook.booksale.utils.AppConstants;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoicedetail")
public class InvoiceDetailController {
    @Autowired
    InvoiceDetailService invoiceDetailService;
    @GetMapping
    public List<InvoicedetailEntity> getAll(@RequestParam(value = "pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
                                            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false)int pageSize,
                                            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false)String sortBy,
                                            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_DEFAULT_SORT_DIRECTION, required = false)String sortDir
    ){
        return invoiceDetailService.getAllInvoiceDetail();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = InvoicedetailEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Post not found", content = @Content) })
    @PostMapping
    public ResponseEntity<InvoicedetailEntity> create(@RequestBody InvoicedetailEntity invoicedetailEntity){
        return new ResponseEntity<>(invoiceDetailService.createInvoiceDetail(invoicedetailEntity), HttpStatus.CREATED);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = InvoicedetailEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Post not found", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<InvoicedetailEntity> getById(@PathVariable(name="id")long id){
        return ResponseEntity.ok(invoiceDetailService.getInvoiceDetail(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<InvoicedetailEntity> update(@RequestBody InvoicedetailEntity bookEntity,@PathVariable(name="id")long id){
        return ResponseEntity.ok(invoiceDetailService.updateInvoiceDetail(bookEntity,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name="id")long id){
        invoiceDetailService.deleteInvoiceDetailById(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }
}
