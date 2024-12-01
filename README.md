# Protocol Buffers Repository for Tick Schema

## Overview
This repository contains a Protocol Buffers (protobuf) definition designed to provide a generic, extensible, and efficient schema for data transfer. The schema is optimized for applications requiring a simple yet powerful structure for defining and managing tick data types. The definitions leverage **proto3** syntax for compatibility with modern Protocol Buffers tooling.

## Key Features
- **Generic Field Types**: Support for a wide range of field types (e.g., integer, long, double, timestamp, and string).
- **Custom Formatting Options**: Flexible formatting specifications for numbers, dates, and times.
- **Localization and Internationalization**: Includes support for locales, time zones, and custom formatting patterns.
- **Version Management**: Built-in versioning support for backward compatibility and iterative schema evolution.
- **Tick Management**: Schema for defining and transmitting tick-based data, commonly used in financial or real-time streaming applications.

## Schema Components

### FieldType
Defines the basic types of data fields, including numeric, timestamp, and string types.

### NumberFormat
Enumerates common number formatting options, such as currency, percentage, or thousands grouping.

### TimeFormat
Specifies formatting patterns for time and date values, ranging from ISO-8601 to localized formats.

### FormatSpec
A message to define field-level formatting options, such as precision, grouping, time zones, and locale settings.

### Version
Supports semantic versioning for schema elements to ensure compatibility and trace changes.

### FieldDefinition
Describes individual fields within a tick type, including metadata, type information, and formatting specifications.

### TickType
Represents a schema for defining types of tick data, including their fields, categories, and timestamps for creation and updates.

### Field
A container for values within a tick, allowing for dynamic, typed data representation.

### Tick
The primary message type for representing tick-based data. Includes a reference to the tick type and the associated field values.

## Example Use Cases
1. **Financial Tick Data**: Capture real-time stock prices, trades, or quotes with structured field definitions.
2. **IoT Sensor Streams**: Define and transmit time-series data with flexible timestamp and number formatting.
3. **Custom Data Pipelines**: Use the schema as a foundation for generic, modular data streaming and analytics.

## Dependencies
- **Protocol Buffers Compiler (`protoc`)**: Version 3.25.1 or higher.
- **Google Timestamp Library**: `google/protobuf/timestamp.proto` is included to support timestamp values.

## Integration
1. Clone the repository:
   ```bash
   git clone https://github.com/dunkware/tick-protobuf.git
   ```

2. Compile the `.proto` file into your desired language using `protoc`:
   ```bash
   protoc --java_out=src/main/java src/main/proto/tick.proto
   ```

3. Include the generated code in your application and use the defined messages for data serialization and deserialization.

## Contribution
Contributions are welcome! Feel free to submit issues, fork the repository, and create pull requests. Ensure your changes align with the project’s goals of simplicity and extensibility.

## License
This repository is licensed under the MIT License. See the `LICENSE` file for details.

---

For more information, contact [Dunkware](https://dunkware.com) or refer to the official [Protocol Buffers Documentation](https://protobuf.dev/).

