package com.springbook.booksale.controller;

import com.springbook.booksale.entity.InvoiceEntity;
import com.springbook.booksale.payload.InvoiceResponse;
import com.springbook.booksale.service.InvoiceService;
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

@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;
    @GetMapping
    public InvoiceResponse getAll(@RequestParam(value = "pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
                                  @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false)int pageSize,
                                  @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false)String sortBy,
                                  @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_DEFAULT_SORT_DIRECTION, required = false)String sortDir
    ){
        return invoiceService.getAllInvoice(pageNo,pageSize,sortBy,sortDir);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = InvoiceEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Post not found", content = @Content) })
    @PostMapping
    public ResponseEntity<InvoiceEntity> create(@RequestBody InvoiceEntity invoiceEntity){
        return new ResponseEntity<>(invoiceService.createInvoice(invoiceEntity), HttpStatus.CREATED);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = InvoiceEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Post not found", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceEntity> getById(@PathVariable(name="id")long id){
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<InvoiceEntity> update(@RequestBody InvoiceEntity bookEntity,@PathVariable(name="id")long id){
        return ResponseEntity.ok(invoiceService.updateInvoice(bookEntity,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name="id")long id){
        invoiceService.deleteInvoiceById(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }
}
