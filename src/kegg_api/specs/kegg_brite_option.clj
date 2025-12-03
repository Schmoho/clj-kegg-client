(ns kegg-api.specs.kegg-brite-option
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def kegg-brite-option-data
  {
   })

(def kegg-brite-option-spec
  (ds/spec
    {:name ::kegg-brite-option
     :spec kegg-brite-option-data}))
