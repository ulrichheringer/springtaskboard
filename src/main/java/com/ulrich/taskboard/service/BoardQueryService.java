package com.ulrich.taskboard.service;

import com.ulrich.taskboard.persistence.dao.BoardColumnDAO;
import com.ulrich.taskboard.persistence.dao.BoardDAO;
import com.ulrich.taskboard.persistence.entity.BoardEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardQueryService {

  private final Connection connection;

  public Optional<BoardEntity> findById(final Long id) throws SQLException {
    var dao = new BoardDAO(connection);
    var boardColumnDAO = new BoardColumnDAO();
    var optional = dao.findById(id);
    if (optional.isPresent()) {
      var entity = optional.get();
      entity.setBoardColumns(boardColumnDAO.findByBoardId(entity.getId()));
      return Optional.of(entity);
    }
    return Optional.empty();
  }
}
