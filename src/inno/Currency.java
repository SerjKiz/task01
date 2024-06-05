package inno;
public class Currency {
    private CodeCur codeCur;
    private Integer countCur;

    public Currency(CodeCur codeCurIn, Integer countCurIn ) {
        codeCur = codeCurIn;
        countCur = countCurIn;
    }

    public CodeCur getCodeCur() {
        return this.codeCur;
    }
    public Integer getCountCur() {
        return this.countCur;
    }

    public void setCodeCur(CodeCur codeCurIn) {

        this.codeCur = codeCurIn;
    }

    public void setCountCur(Integer countCurIn) {
        if (countCurIn < 0){
            throw new IllegalArgumentException("Количество валюты отрицательное");
        }
        this.countCur = countCurIn;
    }

}
