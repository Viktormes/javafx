package se.iths.javatt.javafx;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SVGWriter {
    FileChooser fileChooser = new FileChooser();
    Path filePath;


    public void saveToFile(ShapeModel shapeModel, Stage stage) {
        fileChooser.setInitialFileName("BildensBild");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG-fil", "*.svg"));

        try {
            filePath = fileChooser.showSaveDialog(stage.getOwner()).toPath();
            Files.write(filePath, getShapesAsString(shapeModel));
        } catch (NullPointerException | IOException e) {
            e.getMessage();
        }
    }

    private List<String> getShapesAsString(ShapeModel shapeModel) {
        List<String> stringList = new ArrayList<>();
        stringList.add("<svg width=\"1200.0\" height=\"800.0\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">");
        addShapeToString(stringList, shapeModel);
        stringList.add("</svg>");
        return stringList;
    }

    private void addShapeToString(List<String> stringList, ShapeModel shapeModel) {
        shapeModel.getShapeList().forEach(shape -> stringList.add(String.join(" ", shape.drawToSVGAsString())));
    }

}
