module com.davidbneto.minesweepersolver {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.davidbneto.mine_sweeper to javafx.fxml;
  exports com.davidbneto.mine_sweeper;
}