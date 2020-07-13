(ns concurrent-graph.core-test
  (:require [clojure.test :refer :all]
            [concurrent-graph.core :refer :all]))


(deftest create-concurrent-graph
  (testing "constructs a new concurrent-graph"
    (is (true? (= @(concurrent-graph) {})))
    (is (true? (= @(concurrent-graph) @(concurrent-graph))))))

(deftest adds-vertex-to-graph
  (testing "adds vertex to graph"
    (let [graph (concurrent-graph)]
      (is (true? (= (add-vertex graph :A) {:A #{}})))
      (is (true? (= @graph {:A #{}}))))))

(deftest adds-edge-to-graph
  (testing "adds edge to graph"
    (let [graph (concurrent-graph)]
      (add-vertex graph :A)
      (add-vertex graph :B)
      (is (true? (= (add-edge graph :A :B) {:A #{:B} :B #{:A}})))
      (is (true? (= @graph {:A #{:B} :B #{:A}}))))))
