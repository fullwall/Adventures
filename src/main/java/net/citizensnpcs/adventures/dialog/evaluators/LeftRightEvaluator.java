package net.citizensnpcs.adventures.dialog.evaluators;

public abstract class LeftRightEvaluator implements Evaluator {
    protected Evaluator left, right;

    protected LeftRightEvaluator(Evaluator left, Evaluator right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isConstant() {
        return left.isConstant() && right.isConstant();
    }
}
