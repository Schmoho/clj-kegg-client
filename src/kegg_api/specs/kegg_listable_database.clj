(ns kegg-api.specs.kegg-listable-database
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def kegg-listable-database-data
  {
   })

(def kegg-listable-database-spec
  (ds/spec
    {:name ::kegg-listable-database
     :spec kegg-listable-database-data}))
