package com.example.atividade2

import android.os.Bundle
import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {

    private val CHANNEL = "Toast"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL)
            .setMethodCallHandler { call, result ->

                when (call.method) {

                    "showToast" -> {
                        val message = call.argument<String>("message")
                        if (message != null) {
                            runOnUiThread {
                                Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
                            }
                            result.success(null)
                        } else {
                            result.error("INVALID", "Mensagem nula", null)
                        }
                    }

                    "showDialog" -> {
                        val title = call.argument<String>("title")
                        val message = call.argument<String>("message")
                        if (title != null && message != null) {
                            runOnUiThread {
                                val builder = android.app.AlertDialog.Builder(this)
                                builder.setTitle(title)
                                builder.setMessage(message)
                                builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                                builder.show()
                            }
                            result.success(null)
                        } else {
                            result.error("INVALID", "Título ou mensagem nulos", null)
                        }
                    }

                    else -> result.notImplemented()
                }
            }
    }
}
