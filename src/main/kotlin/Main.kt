import xtdb.api.IXtdb
import xtdb.api.NodeConfiguration

fun main(args: Array<String>) {
    println("Starting XTDB node...")

//    val configuration = mapOf(
//        "xtdb/index-store" to emptyMap(),
//        "xtdb/tx-log" to mapOf(
//            "xtdb/module" to "xtdb.jdbc/->tx-log",
//            "connection-pool" to mapOf(
//                "dialect" to mapOf(
//                    "xtdb/module" to "xtdb.jdbc.psql/->dialect"
//                ),
//                "db-spec" to mapOf(
//                    "host" to "localhost",
//                    "port" to "5433",
//                    "dbname" to "xtdb_transaction_log",
//                    "user" to "xtdb",
//                    "password" to "xtdb"
//                )
//            )
//        )
//    )

//    IXtdb.startNode(configuration)

    IXtdb.startNode { n ->
        n.with("xtdb/tx-log") { txLog ->
            txLog.module("xtdb.jdbc/->tx-log")
            txLog.with("connection-pool") { cp ->
                cp.with("dialect") { dialect ->
                    dialect.module("xtdb.jdbc.psql/->dialect")
                }
                cp.with("db-spec") { dbs ->
                    dbs["host"] = "localhost"
                    dbs["port"] = "5433"
                    dbs["dbname"] = "xtdb_transaction_log"
                    dbs["user"] = "xtdb"
                    dbs["password"] = "xtdb"
                }
            }
        }
        n.with("xtdb/document-store") { }
        n.with("xtdb/index-store") { }
    }
}