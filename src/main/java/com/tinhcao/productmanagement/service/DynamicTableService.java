package com.tinhcao.productmanagement.service;

import com.tinhcao.productmanagement.service.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DynamicTableService {
    private final JdbcTemplate jdbcTemplate;

    public void saveDynamicEntity(String tableName, List<Map<String, String>> records) {
        // Create the table dynamically
        createTable(tableName, records.get(0));

        // Save records dynamically
        for (Map<String, String> record : records) {
            saveRecord(tableName, record);
        }
    }

    private void createTable(String tableName, Map<String, String> record) {
        StringBuilder createTableQuery = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append(tableName)
                .append(" (id INT PRIMARY KEY AUTO_INCREMENT");

        for (Map.Entry<String, String> entry : record.entrySet()) {
            String columnName = entry.getKey();
            createTableQuery.append(", ").append(columnName).append(" VARCHAR(255)");
        }

        createTableQuery.append(");");

        jdbcTemplate.execute(createTableQuery.toString());
    }

    private void saveRecord(String tableName, Map<String, String> record) {
        StringBuilder insertQuery = new StringBuilder("INSERT INTO ").append(tableName).append(" (");

        for (Map.Entry<String, String> entry : record.entrySet()) {
            insertQuery.append(entry.getKey()).append(", ");
        }

        insertQuery.delete(insertQuery.length() - 2, insertQuery.length());
        insertQuery.append(") VALUES (");

        for (Map.Entry<String, String> entry : record.entrySet()) {
            insertQuery.append("'").append(entry.getValue()).append("', ");
        }

        insertQuery.delete(insertQuery.length() - 2, insertQuery.length());
        insertQuery.append(");");

        jdbcTemplate.execute(insertQuery.toString());
    }

    public List<ProductDTO> getAllProducts() {
        return jdbcTemplate.query("SELECT * FROM products", new BeanPropertyRowMapper<>(ProductDTO.class));
    }
}
