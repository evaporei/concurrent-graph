(ns concurrent-graph.core-test
  (:require [clojure.test :refer :all]
            [concurrent-graph.core :refer :all]))


(deftest create-concurrent-graph
  (testing "constructs a new concurrent-graph"
    (is (true? (= @(concurrent-graph) {})))
    (is (true? (= @(concurrent-graph) @(concurrent-graph))))))
