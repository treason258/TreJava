package com.mjiayou.trejava.module.uicalculator;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.math.BigDecimal;

/**
 * Created by treason on 2017/6/20.
 */
public class Calculator extends Application {

    boolean x2 = false;
    boolean res = false;
    String exp = "";

    @Override
    public void start(Stage primaryStage) {

        // ******************************** UI ********************************

        VBox mainPane = new VBox(10);
        mainPane.setPadding(new Insets(10, 10, 10, 10));
        mainPane.prefHeightProperty().bind(primaryStage.heightProperty());
        mainPane.prefWidthProperty().bind(primaryStage.widthProperty());
        mainPane.setStyle("-fx-background-color: #000000;");

        Button improve = new Button("improve");
        improve.prefWidthProperty().bind(mainPane.widthProperty().divide(2));
        improve.prefHeightProperty().bind(mainPane.heightProperty().divide(15));
        improve.setFont(getFont());
        improve.styleProperty().bind(getObservableValueForNum(improve.hoverProperty()));

        Button approximate = new Button("approximate");
        approximate.prefWidthProperty().bind(mainPane.widthProperty().divide(2));
        approximate.prefHeightProperty().bind(mainPane.heightProperty().divide(15));
        approximate.setFont(getFont());
        approximate.styleProperty().bind(getObservableValueForNum(approximate.hoverProperty()));

        Button num9 = new Button("9");
        num9.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num9.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num9.setFont(getFont());
        num9.styleProperty().bind(getObservableValueForNum(num9.hoverProperty()));

        Button num8 = new Button("8");
        num8.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num8.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num8.setFont(getFont());
        num8.styleProperty().bind(getObservableValueForNum(num8.hoverProperty()));

        Button num7 = new Button("7");
        num7.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num7.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num7.setFont(getFont());
        num7.styleProperty().bind(getObservableValueForNum(num7.hoverProperty()));

        Button div = new Button("/");
        div.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        div.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        div.setFont(getFont());
        div.styleProperty().bind(getObservableValueForOption(div.hoverProperty()));

        Button backSpace = new Button("\u2190");
        backSpace.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        backSpace.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        backSpace.setFont(getFont());
        backSpace.styleProperty().bind(getObservableValueForControl(backSpace.hoverProperty()));

        Button home = new Button("\u2302");
        home.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        home.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        home.setFont(getFont());
        home.styleProperty().bind(getObservableValueForControl(home.hoverProperty()));

        Button num6 = new Button("6");
        num6.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num6.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num6.setFont(getFont());
        num6.styleProperty().bind(getObservableValueForNum(num6.hoverProperty()));

        Button num5 = new Button("5");
        num5.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num5.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num5.setFont(getFont());
        num5.styleProperty().bind(getObservableValueForNum(num5.hoverProperty()));

        Button num4 = new Button("4");
        num4.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num4.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num4.setFont(getFont());
        num4.styleProperty().bind(getObservableValueForNum(num4.hoverProperty()));

        Button mul = new Button("*");
        mul.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        mul.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        mul.setFont(getFont());
        mul.styleProperty().bind(getObservableValueForOption(mul.hoverProperty()));

        Button b1 = new Button("(");
        b1.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        b1.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        b1.setFont(getFont());
        b1.styleProperty().bind(getObservableValueForControl(b1.hoverProperty()));

        Button b2 = new Button(")");
        b2.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        b2.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        b2.setFont(getFont());
        b2.styleProperty().bind(getObservableValueForControl(b2.hoverProperty()));

        Button num3 = new Button("3");
        num3.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num3.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num3.setFont(getFont());
        num3.styleProperty().bind(getObservableValueForNum(num3.hoverProperty()));

        Button num2 = new Button("2");
        num2.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num2.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num2.setFont(getFont());
        num2.styleProperty().bind(getObservableValueForNum(num2.hoverProperty()));

        Button num1 = new Button("1");
        num1.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num1.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num1.setFont(getFont());
        num1.styleProperty().bind(getObservableValueForNum(num1.hoverProperty()));

        Button sub = new Button("-");
        sub.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        sub.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        sub.setFont(getFont());
        sub.styleProperty().bind(getObservableValueForOption(sub.hoverProperty()));

        Button xPower2 = new Button("x²");
        xPower2.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        xPower2.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        xPower2.setFont(getFont());
        xPower2.styleProperty().bind(getObservableValueForControl(xPower2.hoverProperty()));

        Button sqrt = new Button("\u221A");
        sqrt.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        sqrt.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        sqrt.setFont(getFont());
        sqrt.styleProperty().bind(getObservableValueForControl(sqrt.hoverProperty()));

        Button dot = new Button(".");
        dot.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        dot.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        dot.setFont(getFont());
        dot.styleProperty().bind(getObservableValueForOption(dot.hoverProperty()));

        Button num0 = new Button("0");
        num0.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num0.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        //num0.setStyle("-fx-line-height: 1.8;");
        num0.setFont(getFont());
        num0.styleProperty().bind(getObservableValueForNum(num0.hoverProperty()));

        Button mod = new Button("%");
        mod.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        mod.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        mod.setFont(getFont());
        mod.styleProperty().bind(getObservableValueForOption(mod.hoverProperty()));

        Button sum = new Button("+");
        sum.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        sum.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        sum.setFont(getFont());
        sum.styleProperty().bind(getObservableValueForOption(sum.hoverProperty()));

        Button equal = new Button("=");
        equal.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        equal.prefWidthProperty().bind(mainPane.widthProperty().divide(3));
        equal.setFont(getFont());
        equal.styleProperty().bind(getObservableValueForEqual(equal.hoverProperty()));

        // ******************************** UI ********************************

        TextField textField = new TextField();
        textField.prefHeightProperty().bind(mainPane.heightProperty().divide(3));
        textField.setStyle("-fx-font-size:29px;");
        textField.setAlignment(Pos.BOTTOM_RIGHT);

        HBox hBox0 = new HBox(10);
        hBox0.getChildren().addAll(improve, approximate);

        HBox hBox1 = new HBox(5);
        hBox1.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
        hBox1.prefWidthProperty().bind(primaryStage.widthProperty());
        hBox1.getChildren().addAll(num9, num8, num7, div, backSpace, home);

        HBox hBox2 = new HBox(5);
        hBox2.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
        hBox2.prefWidthProperty().bind(primaryStage.widthProperty());
        hBox2.getChildren().addAll(num6, num5, num4, mul, b1, b2);

        HBox hBox3 = new HBox(5);
        hBox3.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
        hBox3.prefWidthProperty().bind(primaryStage.widthProperty());
        hBox3.getChildren().addAll(num3, num2, num1, sub, xPower2, sqrt);

        HBox hBox4 = new HBox(5);
        hBox4.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
        hBox4.prefWidthProperty().bind(primaryStage.widthProperty());
        hBox4.getChildren().addAll(dot, num0, mod, sum, equal);

        // ******************************** ACTION ********************************

        num0.setOnMouseClicked(e -> {
            String x = "0";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "0";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        num1.setOnMouseClicked(e -> {
            String x = "1";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "1";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        num2.setOnMouseClicked(e -> {
            String x = "2";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "2";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        num3.setOnMouseClicked(e -> {
            String x = "3";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "3";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        num4.setOnMouseClicked(e -> {
            String x = "4";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "4";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        num5.setOnMouseClicked(e -> {
            String x = "5";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "5";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        num6.setOnMouseClicked(e -> {
            String x = "6";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "6";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        num7.setOnMouseClicked(e -> {
            String x = "7";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "7";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        num8.setOnMouseClicked(e -> {
            String x = "8";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "8";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        num9.setOnMouseClicked(e -> {
            String x = "9";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "9";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        dot.setOnMouseClicked(e -> {
            if (x2 == false) {
                String x = ".";
                exp += x;
                textField.setText(exp);
                res = false;
                x2 = true;
            }
        });

        sum.setOnMouseClicked(e -> {
            String x = "+";
            exp += x;
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        sub.setOnMouseClicked(e -> {
            String x = "-";
            exp += x;
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        mul.setOnMouseClicked(e -> {
            String x = "*";
            exp += x;
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        div.setOnMouseClicked(e -> {
            String x = "/";
            exp += x;
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        mod.setOnMouseClicked(e -> {
            String x = "%";
            exp += x;
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        backSpace.setOnMouseClicked(e -> {
            try {
                int i = 1;
                exp = exp.substring(0, exp.length() - i);
                i++;
                textField.setText(exp);
                res = false;
                x2 = false;
            } catch (IndexOutOfBoundsException ex) {
                ex.printStackTrace();
            }
        });

        home.setOnMouseClicked(e -> {
            exp = "";
            textField.setText(exp);
            x2 = false;
            res = false;
        });

        b1.setOnMouseClicked(e -> {
            exp += "(";
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        b2.setOnMouseClicked(e -> {
            exp += ")";
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        xPower2.setOnMouseClicked(e -> {
            exp += "^";
            int yy = 0;
            int yy2 = 0;
            for (int i = 0; i < exp.length(); i++) {
                if (exp.charAt(i) == '^') {
                    yy = i;
                }
            }
            for (int i = yy; i >= 1; i--) {
                if ((exp.charAt(i) == '-' || exp.charAt(i) == '+' || exp.charAt(i) == '*' ||
                        exp.charAt(i) == '%' || exp.charAt(i) == '/') && i != 0) {
                    yy2 = i + 1;
                    break;
                }
            }
            String h = exp.substring(0, yy2);
            String u = exp.substring(yy2, yy);
            exp = "";
            exp = h + "(" + u + "^" + ")";

            textField.setText(exp);
            res = false;
            x2 = false;
        });

        sqrt.setOnMouseClicked(e -> {
            exp += "S" + "(";
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        improve.setOnMouseClicked(e -> {
            try {
                Double toBeTruncated = new Double(exp);
                Double truncatedDouble = new BigDecimal(toBeTruncated)
                        .setScale(2, BigDecimal.ROUND_HALF_UP)
                        .doubleValue();
                exp = Double.toString(truncatedDouble);
                textField.setText(exp);
            } catch (NullPointerException ex) {
                exp = "Erorr Expression";
                textField.setText(exp);
                exp = "";
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                exp = "Erorr Expression";
                textField.setText(exp);
                exp = "";
                ex.printStackTrace();
            }
        });

        approximate.setOnMouseClicked(e -> {
            try {
                double result2 = Double.parseDouble(exp);
                double result = Math.round(result2);
                int YY = (int) result;
                String XX = Integer.toString(YY);
                exp = XX;
                textField.setText(exp);
                res = true;
                x2 = false;
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });

        equal.setOnMouseClicked(e -> {
            try {
                exp = ComputeUtil.solve(exp);
                textField.setText(exp);
                res = true;
                x2 = false;
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });

        // ******************************** UI ********************************

        textField.setDisable(true);
        mainPane.getChildren().addAll(textField, hBox0, hBox1, hBox2, hBox3, hBox4);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(mainPane, 410, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private Font getFont() {
        return Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12); // REGULAR
    }

    private ObservableValue<? extends String> getObservableValueForNum(ObservableBooleanValue condition) {
        return Bindings.when(condition)
                .then(new SimpleStringProperty("-fx-color: gray;"))
                .otherwise(new SimpleStringProperty("-fx-color: white;"));
    }

    private ObservableValue<? extends String> getObservableValueForOption(ObservableBooleanValue condition) {
        return Bindings
                .when(condition)
                .then(new SimpleStringProperty("-fx-color: #949494;"))
                .otherwise(new SimpleStringProperty("-fx-color: #2e2e2e;"));
    }

    private ObservableValue<? extends String> getObservableValueForControl(ObservableBooleanValue condition) {
        return Bindings
                .when(condition)
                .then(new SimpleStringProperty("-fx-color: #4f7aa2;"))
                .otherwise(new SimpleStringProperty("-fx-color: #34516e;"));
    }

    private ObservableValue<? extends String> getObservableValueForEqual(ObservableBooleanValue condition) {
        return Bindings
                .when(condition)
                .then(new SimpleStringProperty("-fx-color: #f4a54d;"))
                .otherwise(new SimpleStringProperty("-fx-color: #b96501;"));
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
