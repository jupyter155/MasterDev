// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package com.example.Data;

public interface DataTrackingOrBuilder extends
    // @@protoc_insertion_point(interface_extends:DataTracking)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>required string version = 1;</code>
   */
  boolean hasVersion();
  /**
   * <code>required string version = 1;</code>
   */
  java.lang.String getVersion();
  /**
   * <code>required string version = 1;</code>
   */
  com.google.protobuf.ByteString
      getVersionBytes();

  /**
   * <code>required string name = 2;</code>
   */
  boolean hasName();
  /**
   * <code>required string name = 2;</code>
   */
  java.lang.String getName();
  /**
   * <code>required string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>required fixed64 timestamp = 3;</code>
   */
  boolean hasTimestamp();
  /**
   * <code>required fixed64 timestamp = 3;</code>
   */
  long getTimestamp();

  /**
   * <code>optional string phone_id = 4;</code>
   */
  boolean hasPhoneId();
  /**
   * <code>optional string phone_id = 4;</code>
   */
  java.lang.String getPhoneId();
  /**
   * <code>optional string phone_id = 4;</code>
   */
  com.google.protobuf.ByteString
      getPhoneIdBytes();

  /**
   * <code>optional fixed64 lon = 5;</code>
   */
  boolean hasLon();
  /**
   * <code>optional fixed64 lon = 5;</code>
   */
  long getLon();

  /**
   * <code>optional fixed64 lat = 6;</code>
   */
  boolean hasLat();
  /**
   * <code>optional fixed64 lat = 6;</code>
   */
  long getLat();
}
