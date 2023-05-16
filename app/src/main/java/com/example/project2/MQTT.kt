package com.example.project2

import android.content.Context
import android.util.Log
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.IMqttMessageListener
import org.eclipse.paho.client.mqttv3.IMqttToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence

class MQTT {

    private val brokerUrl = "tcp://test.mosquitto.org:1883"
    private val clientId = "clientId"
    private val topic = "najwan/Bedroom/lamp"

    private lateinit var client: MqttAndroidClient

    fun connectBroker(context: Context) {
        client = MqttAndroidClient(context, brokerUrl, clientId)

        val options = MqttConnectOptions()
        options.isCleanSession = true

        try {
            client.connect(options, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken?) {
                    Log.d(TAG, "Connected to MQTT broker")
                    subscribeToTopic()
                }

                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                    Log.e(TAG, "Failed to connect to MQTT broker: $exception")
                }
            })
        } catch (ex: MqttException) {
            Log.e(TAG, "Failed to connect to MQTT broker: $ex")
        }
    }

    fun sendMessage(message: String) {
        val mqttMessage = MqttMessage(message.toByteArray())
        mqttMessage.qos = 1
        try {
            client.publish(topic, mqttMessage)
            Log.d(TAG, "Message sent: $message")
        } catch (ex: MqttException) {
            Log.e(TAG, "Failed to send message: $ex")
        }
    }

    fun receiveMessage() {
        try {
            client.subscribe(topic, 1
            ) { topic, message -> Log.d(TAG, "Message received: ${message?.toString()}") }
        } catch (ex: MqttException) {
            Log.e(TAG, "Failed to subscribe to topic: $ex")
        }
    }

    private fun subscribeToTopic() {
        try {
            client.subscribe(topic, 1)
            Log.d(TAG, "Subscribed to topic: $topic")
        } catch (ex: MqttException) {
            Log.e(TAG, "Failed to subscribe to topic: $ex")
        }
    }

    companion object {
        private const val TAG = "MQTT"
    }
}

