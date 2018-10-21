package com.tcc.tcc.repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tcc.tcc.entidades.Ocorrencia;

public class CrimeRepositorioImpl implements CrimeRepositorioCustom {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Ocorrencia> buscarCrimes(Long criminosoID) {

		String sql = "SELECT B.ID, B.DATA, B.DESCRICAO, B.HORA FROM CRIMES A INNER JOIN OCORRENCIAS B ON B.ID = A.OCORRENCIA_ID WHERE A.CRIMINOSO_ID =" + criminosoID;

		return jdbcTemplate.query(sql, new RowMapper<Ocorrencia>() {
			@Override
			public Ocorrencia mapRow(ResultSet rs, int rownumber) throws SQLException {

				Ocorrencia ocorrencia = new Ocorrencia();

				ocorrencia.setId(rs.getLong(1));
				ocorrencia.setData(LocalDate.parse(rs.getString(2)));
				ocorrencia.setDescricao(rs.getString(3));
				ocorrencia.setHora(LocalTime.parse(rs.getString(4)));
				
				return ocorrencia;
			}
		});

	}

}
